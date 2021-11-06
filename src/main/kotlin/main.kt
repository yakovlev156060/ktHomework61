fun main() {
}
object WallService{
    private var nextId=0
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val newPost:Post=post.copy(nextId+1)
        posts+=newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex()) {
            if (value.id == post.id) {
                posts[index] =
                    post.copy(ownerId = posts[index].ownerId, createdBy = posts[index].createdBy)
                return true
            }
        }
        return false
    }
}

public data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String?,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments?,
    val copyright: Copyright?,
    val likes: Likes,
    val reposts: Reposts?,
    val views: Views?,
    val postType: String,
    val signerId: Int,
    val copyHistory: Array<Post>,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Int,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int,
    val attachments: Array<Attachment>?
){
    private var nextId:Int=0

}

interface Attachment{
    val type: String
}

public class AudioAttachment(
    override val type:String = "Audio",
    val audio: Audio=Audio()):Attachment{
}
/*
class AudioAttachment(override val type: String="audio"
val audio: Audio=Audio()) : Attachment
*/

public class PhotoAttachment(
    override val type:String = "Photo",
    val photo: Photo=Photo()):Attachment{
}

public class PostedPhotoAttachment(
    override val type:String = "PostedPhoto",
    val postedPhoto: PostedPhoto=PostedPhoto()):Attachment{
}

public class WikiPageAttachment(
    override val type:String = "WikiPage",
    val wikiPage: WikiPage=WikiPage()):Attachment{
}

public class NoteAttachment(
    override val type:String = "Note",
    val note: Note=Note()
):Attachment{
}

public class Audio(
    val id: Int=0,
    val ownerId: Int=0,
    val artist:String="",
    val title:String="",
    val duration: Int=0,
    val lyricsId:String="",
    val albumId: Int=0,
    val genreId: Int=0,
    val date: Int=0,
    val noSearch: Boolean=true,
    val isHq: Boolean=true){

}

public class Photo(
    val id: Int=0,
    val albumId: Int=0,
    val userId: Int=0,
    val text:String="",
    val date: Int=0,
    val width: Int=0,
    val height: Int=0){
}

public class PostedPhoto(
    val id: Int=0,
    val ownerId: Int=0,
    val photo_130:String="",
    val photo_604:String=""){
}

public class WikiPage(
    val id: Int=0,
    val groupId: Int=0,
    val title:String=""){
}

public class Note(
    val id: Int=0,
    val ownerId: Int=0,
    val title:String="",
    val text:String="",
    val date: Int=0,
    val comments: Int=0,
    val readComments: Int=0,
    val viewUrl:String="",
    val privacyView:String="",
    val privacyComment:String="",
    val canComment: Boolean=true,
    val textWiki:String=""){
}

public data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true){
}

public data class Copyright(
    val link: String = "",
    val name: String = "",
    val type: String = ""){
}

public data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true){
}

public data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = false){
}

public data class Views(
    val count: Int = 0){
}

public data class Donut(
    val isDonut: Boolean = true,
    val paidDuration: Int = 0,
    val placeholder: Placeholder = Placeholder(),
    val canPublishFreeCopy: Boolean = true,
    val editMode: String = ""){
}

public final class Placeholder(){

}