import sys.process._

val doc = scala.io.Source.fromURL("https://github.com/yarwest/Git-production-trigger/commits/master", "UTF-8")
val commitString: String = ".*class=\"message\".*"

val latestHash = retrieveCommitHash(doc.getLines.filter(line => line.matches(commitString)).next)

doc.close

val currentHash = scala.io.Source.fromFile(".git/refs/heads/master").getLines.next

if(!currentHash.equals(latestHash)) {
    println("It seems the remote repository is ahead of the local repository. Pulling to retrieve the changes.")
    if("git pull".! != 0) {
        println("There was a problem while updating the repository.")
    }
}

def retrieveCommitHash(str : String) : String = {
    return str.replaceFirst("</a>", "").replaceFirst("^.*href=\".*/", "").replaceFirst("\".*$", "")
}
