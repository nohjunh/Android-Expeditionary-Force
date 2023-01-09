package com.nohjunh.sampleapp.data

import android.content.res.Resources
import com.nohjunh.sampleapp.R

// 초기 flowers 목록 반환
/*
The Android resource system keeps track of all non-code assets associated with an application.
You can use this class to access your application's resources.
You can generally acquire the Resources instance associated with your application with getResources()
*/
fun flowerList(resources: Resources) : List<Flower> {
    return listOf(
        Flower(
            id = 1,
            name = resources.getString(R.string.flower1_name),
            image = R.drawable.rose,
            description = resources.getString(R.string.flower1_description)
        ),
        Flower(
            id = 2,
            name = resources.getString(R.string.flower2_name),
            image = R.drawable.freesia,
            description = resources.getString(R.string.flower2_description)
        ),
        Flower(
            id = 3,
            name = resources.getString(R.string.flower3_name),
            image = R.drawable.lily,
            description = resources.getString(R.string.flower3_description)
        ),
        Flower(
            id = 4,
            name = resources.getString(R.string.flower4_name),
            image = R.drawable.sunflower,
            description = resources.getString(R.string.flower4_description)
        ),
        Flower(
            id = 5,
            name = resources.getString(R.string.flower5_name),
            image = R.drawable.peony,
            description = resources.getString(R.string.flower5_description)
        ),
        Flower(
            id = 6,
            name = resources.getString(R.string.flower6_name),
            image = R.drawable.daisy,
            description = resources.getString(R.string.flower6_description)
        ),
        Flower(
            id = 7,
            name = resources.getString(R.string.flower7_name),
            image = R.drawable.lilac,
            description = resources.getString(R.string.flower7_description)
        ),
        Flower(
            id = 8,
            name = resources.getString(R.string.flower8_name),
            image = R.drawable.marigold,
            description = resources.getString(R.string.flower8_description)
        ),
        Flower(
            id = 9,
            name = resources.getString(R.string.flower9_name),
            image = R.drawable.poppy,
            description = resources.getString(R.string.flower9_description)
        ),
        Flower(
            id = 10,
            name = resources.getString(R.string.flower10_name),
            image = R.drawable.daffodil,
            description = resources.getString(R.string.flower10_description)
        ),
        Flower(
            id = 11,
            name = resources.getString(R.string.flower11_name),
            image = R.drawable.dahlia,
            description = resources.getString(R.string.flower11_description)
        )
    )
}