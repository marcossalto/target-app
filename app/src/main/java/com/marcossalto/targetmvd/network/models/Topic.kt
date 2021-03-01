package com.marcossalto.targetmvd.network.models

import com.marcossalto.targetmvd.models.TopicModel
import com.marcossalto.targetmvd.models.TopicTypes
import com.squareup.moshi.Json

data class Topic(
    @Json(name = "id") val id: Int,
    @Json(name = "label") val label: String = "",
    @Json(name = "icon") val icon: String = ""
)

data class TopicsSerializer(@Json(name = "topics") val topics: List<TopicSerializer>)

data class TopicSerializer(@Json(name = "topic") val topic: Topic)

fun Topic.toTopicModel(): TopicModel? {
    val topicLabel = TopicTypes.valueOf(label.toUpperCase())

    return TopicModel(
        id = id,
        label = topicLabel,
        icon = icon
    )
}