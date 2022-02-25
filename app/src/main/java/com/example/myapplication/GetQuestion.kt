package com.example.myapplication

object Constants{
    fun getQuestions():ArrayList<Question>{
        var outputArray=ArrayList<Question>();
        val qst_1=Question(
            1,
            "adasd",
            12,
            "ADASD",
            "ADASD",
            "ADASD",
            "ADASD",
            12
        )
        outputArray.add(qst_1)
        return outputArray;
    }
}