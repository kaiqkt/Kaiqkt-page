package com.kaiqkt.models

enum class Experience(
    val number: String,
    val position: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "01",
        position = "Tech Analyst Mid",
        description = JOB_DESCRIPTION,
        company = "C6 Bank",
        from = "March 2022",
        to = "NOW",
    ),
    Second(
        number = "02",
        position = "Tech Analyst Junior",
        description = JOB_DESCRIPTION,
        company = "C6 Bank",
        from = "June 2021",
        to = "March 2022",
    ),
    Third(
        number = "03",
        position = "Trainee",
        description = JOB_DESCRIPTION,
        company = "C6 Bank",
        from = "January 2020",
        to = "June 2021",
    )
}

private const val JOB_DESCRIPTION =
    "I work in the development of the global account product, in areas such as multi-currency, debit transaction, remittances and forex. I develop, test, release and maintain new features that add value to the overall banking experience."