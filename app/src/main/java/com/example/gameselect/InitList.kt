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
                ModelList("Where is the PSG?", R.drawable.psg_logo, R.drawable.zenit_logo, "A", "B", "A", ""),
                ModelList("Where is the Milan?", R.drawable.am_logo, R.drawable.juventus_logo, "A", "B", "A", ""),
                ModelList("Which one is in La liga?", R.drawable.am_logo, R.drawable.psg_logo, "A", "B", "A", ""),
                ModelList("Which one is in English Premier League?", R.drawable.arsenal_logo, R.drawable.rm_logo, "A", "B", "A", ""),
                ModelList("Where is the Russian Premier League?", R.drawable.ms_logo, R.drawable.zenit_logo, "A", "B", "B", "")
               )
            for (question in questions) {
                modelList.add(question)
            }
            return modelList
        }
}