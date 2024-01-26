package org.edu.yamini.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
  "id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
            "street": "Kulas Light",
            "suite": "Apt. 556",
            "city": "Gwenborough",
            "zipcode": "92998-3874",
            "geo": {
                "lat": "-37.3159",
                "lng": "81.1496"
            }
        },
        "phone": "1-770-736-8031 x56442",
        "website": "hildegard.org",
        "company": {
            "name": "Romaguera-Crona",
            "catchPhrase": "Multi-layered client-server neural-net",
            "bs": "harness real-time e-markets"
        }
 */
@Entity
data class Users(

    var name :String? = null,
    var username :String? = null,
    var email :String? = null,
    var phone :String? = null,
    var website :String? = null,
    )
{
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null
}
