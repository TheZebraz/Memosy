package by.mastihin.memosy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var memoList:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupList()
    }

    private fun setupList() {
        memoList = findViewById<RecyclerView>(R.id.recyclerview_main)
        memoList.layoutManager = GridLayoutManager(this, 2)
        memoList.adapter = MemAdapter(getMems(), object : MemAdapter.OnMemClickListener{
            override fun onItemClick(item: Mem) {
                Toast.makeText(applicationContext, "Да ладно", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getMems(): List<Mem> {
        val mems: MutableList<Mem> = mutableListOf<Mem>()
        for (i in 1..10) {
            mems.add(Mem("Мем", "https://i.ytimg.com/vi/H_-J_iFk_RQ/maxresdefault.jpg", ""))
        }
        return mems;
    }
}
