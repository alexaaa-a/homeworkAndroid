package com.first.homework

object GossipGirlRepository {

    val gossipG = arrayListOf(
        GossipGirl(
            id = 1,
            character = "Blair Waldorf",
            quote = "What I want is to become a powerful woman.",
            url = "https://i.pinimg.com/736x/7b/61/51/7b6151446c64ce03ecbcc7b535e5f635.jpg"
        ),
        GossipGirl(
            id = 2,
            character = "Chuck Bass",
            quote = "People like me don’t write books. They’re written about.",
            url = "https://i.pinimg.com/736x/bd/6a/28/bd6a286cc08bc78207492ff2df22b2b0.jpg"
        ),
        GossipGirl(
            id = 3,
            character = "Serena van der Woodsen",
            quote = "I like the way I feel when he looks at me. Like I wanna believe in myself.",
            url = "https://i.pinimg.com/736x/58/a5/c3/58a5c3fb31dc4c2aafeb1f4b1b7809a9.jpg"
        ),
        GossipGirl(
            id = 4,
            character = "Nate Archibald",
            quote = "I just want to be the person you can bring anything to.",
            url = "https://i.pinimg.com/736x/5f/b4/9f/5fb49fb1ee010af47ee931581397b3e2.jpg"
        ),
        GossipGirl(
            id = 5,
            character = "Dan Humphrey",
            quote = "She doesn’t know me. Nobody knows me. It’s cool. It’s fine.",
            url = "https://i.pinimg.com/736x/89/5d/5d/895d5d4d163c41df0c236f7e48b2086d.jpg"
        ),
        GossipGirl(
            id = 6,
            character = "Rufus Humphrey",
            quote = "Well, an artist never feels his work is perfect. It’s good to always strive for more.",
            url = "https://i.pinimg.com/736x/48/36/3e/48363eedf8b32c0eef214bfe47dd7c27.jpg"
        ),
        GossipGirl(
            id = 7,
            character = "Lily van der Woodsen",
            quote = "Teenage girls are nightmares. As soon as they realize that you’ll love them no matter what they do, you lose all your power. You just have to wait until they finish college.",
            url = "https://i.pinimg.com/736x/69/41/37/694137bac2df4465deea108f9d0c4842.jpg"
        ),
        GossipGirl(
            id = 8,
            character = "Eleanor Waldorf-Rose",
            quote = "Sometimes, you have to allow yourself to be weak in order to grow stronger.",
            url = "https://i.pinimg.com/736x/23/f8/dc/23f8dc0f7d44519f057a93a41555c463.jpg"
        ),
        GossipGirl(
            id = 9,
            character = "Dorota",
            quote = "In Poland, we have a saying, 'Love is like head wound.' It make you dizzy, you think you die, but you recover. Usually.",
            url = "https://i.pinimg.com/736x/29/10/df/2910df8676d67fbb13f1e1588c04598f.jpg"
        ),
        GossipGirl(
            id = 10,
            character = "Jenny Humphrey",
            quote = "I’m not Little J anymore.",
            url = "https://i.pinimg.com/736x/ea/84/4e/ea844e9c4cda7ef86ea5aec9cebd9eaf.jpg"
        ),
        GossipGirl(
            id = 11,
            character = "Eric van der Woodsen",
            quote = "No guy in the history of the world has ever hated you.",
            url = "https://i.pinimg.com/736x/eb/35/5b/eb355b74474a24c5cad9609952d11420.jpg"
        )
    )

    val GGUI: MutableList<GGItem.GGUiModel>
        get() = gossipG.map {
            val titleColor = if (it.id % 2 != 0) {
                R.color.pink
            }
            else {R.color.light_purple}

            GGItem.GGUiModel(
                id = it.id,
                character = it.character,
                quote = it.quote,
                url = it.url,
                isFav = it.isFav,
                titleColor = titleColor
            )
        }.toMutableList()
}