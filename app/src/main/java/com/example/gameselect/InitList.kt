package com.example.gameselect

class InitList {
    val getQuestions: List<ModelList>
        get() {
            val modelList: MutableList<ModelList> = ArrayList<ModelList>()
            val questions = listOf(
                ModelList("Where is the Arsenal?", R.drawable.chelsea_logo, R.drawable.arsenal_logo, "A", "B", "B", ""),
                ModelList("Where is the Barcelona?", R.drawable.barcelona_logo, R.drawable.rm_logo, "A", "B", "A", ""),
                ModelList("Where is the Ajax?", R.drawable.galatasaray_logo, R.drawable.ajax_logo, "A", "B", "B", ""),
                ModelList("Where is the Manchester City?", R.drawable.ms_logo, R.drawable.mu_logo, "A", "B", "A", ""),
                ModelList("Where is the PSG?", R.drawable.psg_logo, R.drawable.zenit_logo, "A", "B", "A", "")
            )
            for (question in questions) {
                modelList.add(question)
            }
            return modelList
        }
}