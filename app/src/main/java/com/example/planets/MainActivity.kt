package com.example.planets

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.planet_card.view.*

class MainActivity : AppCompatActivity() {
    var constList=ArrayList<Planets>()
    var adapter:PlanetAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constList.add(Planets(Adi = "Mars", Aciklama = "Açıklama", R.drawable.mars))
        constList.add(Planets(Adi = "Neptune", Aciklama = "Açıklama", R.drawable.neptune))
        constList.add(Planets(Adi = "Jupiter", Aciklama = "Açıklama", R.drawable.jupiter))
        constList.add(Planets(Adi = "Uranus", Aciklama = "Açıklama", R.drawable.uranus))
        constList.add(Planets(Adi = "Venus", Aciklama = "Açıklama", R.drawable.venus))

        adapter=PlanetAdapter(this,constList)
        listview.adapter=adapter
    }
    class PlanetAdapter: BaseAdapter {
        var constList=ArrayList<Planets>()
        var context:Context?=null

        constructor(context: Context, constList:ArrayList<Planets>):super(){
            this.constList=constList
            this.context=context
        }

        override fun getCount(): Int {
            return constList.size
        }

        override fun getItem(p0: Int): Any {
            return constList[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var posPlanets:Planets=constList[p0]
            var inflator:LayoutInflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var PlanetCard:View = inflator.inflate(R.layout.planet_card,null)

            PlanetCard.Planetname.text = posPlanets.Adi
            PlanetCard.planet.text = posPlanets.Aciklama
            PlanetCard.planetimg.setImageResource(posPlanets.Resim!!)
            return PlanetCard
        }

    }
}