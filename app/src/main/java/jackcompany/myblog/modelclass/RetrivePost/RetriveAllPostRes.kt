package jackcompany.myblog.modelclass.RetrivePost

data class RetriveAllPostRes(
    val etag: String,
    val items: List<Item>,
    val kind: String
)