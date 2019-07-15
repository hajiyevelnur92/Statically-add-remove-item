package com.studydrive.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.github.javafaker.Faker
import java.util.*


class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this,
            (application as CreateItemApp).viewModelFactory).get(MainViewModel::class.java)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val faker = Faker()

        val producer = findViewById<Button>(R.id.add_producer)
        val consumer = findViewById<Button>(R.id.add_consumer)

        producer.setOnClickListener {
            val fullname = faker.name().fullName()
            val id = UUID.randomUUID().toString()
            mainViewModel.addItem(
                CreateItem(
                    id = id,
                    text = "Producer: $fullname"
                )
            )
        }

        consumer.setOnClickListener {
            val fullname = faker.name().fullName()
            val id = UUID.randomUUID().toString()
            mainViewModel.addItem(
                CreateItem(
                    id = id,
                    text = "Consumer: $fullname"
                )
            )
        }

        val list = findViewById<RecyclerView>(R.id.list)
        list.adapter = adapter

        mainViewModel.items.observe(this, Observer { adapter.submitList(it) })
    }

    private val adapter = object : CreateItemListAdapter() {
        override fun deleteItem(itemId: String) {
            mainViewModel.deleteById(itemId)
        }
    }

}