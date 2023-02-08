package com.example.gameselect

class InitList {
    val getQuestions: List<ModelList>
        get() {
            val modelList: MutableList<ModelList> = ArrayList<ModelList>()
            val questions = listOf(
                ModelList("Who is Soccer", R.drawable.img, R.drawable.img_3, "A", "B", "A", ""),
                ModelList("Who is Basketball", R.drawable.img_3, R.drawable.img_2, "A", "B", "B", ""),
                ModelList("Who is Tennis", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, "A", "B", "A", ""),
                ModelList("Who is Boxer", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, "A", "B", "A", ""),
                ModelList("Who is Swimmer", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background, "A", "B", "B", "")
            )
            for (question in questions) {
                modelList.add(question)
            }
            return modelList
        }
}