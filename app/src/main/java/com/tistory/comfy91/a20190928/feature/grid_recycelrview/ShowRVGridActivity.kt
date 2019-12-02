package com.tistory.comfy91.a20190928.feature.grid_recycelrview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tistory.comfy91.a20190928.R
import com.tistory.comfy91.a20190928.data.GridItem

class ShowRVGridActivity : AppCompatActivity() {
    lateinit var rvShowRVGrid: RecyclerView
    lateinit var rvGridAdapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvgrid)

        rvShowRVGrid = findViewById(R.id.rvShowRVGrid)
        rvGridAdapter = GridAdapter(this)
        rvShowRVGrid.adapter = rvGridAdapter
        rvShowRVGrid.layoutManager = GridLayoutManager(this, 3)

        rvGridAdapter.data = listOf(
            GridItem(
                img = "yoomee",
                title = "유미의 세포들",
                starScore = "9.96",
                author = "이동건"
            ),
            GridItem(
                img = "bokhak",
                title = "복학왕",
                starScore = "9.20",
                author = "기안84"
            ),
            GridItem(
                img = "yeonnome",
                title = "연놈",
                starScore = "9.92",
                author = "상하"
            ),


            GridItem(
                img = "wordlismoney",
                title = "세상은 돈과 권련",
                starScore = "9.87",
                author = "한동우/이도희"
            ),
            GridItem(
                img = "helper",
                title = "헬퍼 2: 킬베로스",
                starScore = "9.91",
                author = "삭"
            ),
            GridItem(
                img = "itsmine",
                title = "이츠마인",
                starScore = "9.97",
                author = "럭스"
            )

            ,
            GridItem(
                img = "marryantifan",
                title = "그래서 나는 안티팬과 결혼했다.",
                starScore = "9.94",
                author = "채림"
            ),
            GridItem(
                img = "godmulju",
                title = "갓물주",
                starScore = "9.92",
                author = "HD3"
            ),
            GridItem(
                img = "gaejanwu",
                title = "개장수",
                starScore = "9.98",
                author = "김규삼"
            )


        )
    }
}
