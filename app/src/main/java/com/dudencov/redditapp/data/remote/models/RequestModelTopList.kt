package com.dudencov.redditapp.data.remote.models

/**See detail API: https://www.reddit.com/dev/api/#GET_top*/
data class RequestModelTopList(
    /**Indicate the fullname of an item in the listing to use as the anchor point of the slice.*/
    val itemName: String? = null,

    /**The maximum number of items to return in this slice of the listing.*/
    val limit: Int? = null,

    /**
     * The number of items already seen in listing. on the html site, the builder uses this to
     * ldetermine when to give values for before and after in the response.
     * */
    val count: Int? = null,

    /**Optional parameter; if "all" is passed, filters such as "hide links that I have voted on" will be disabled.*/
    val show: String? = null
)