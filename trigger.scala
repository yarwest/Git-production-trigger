val doc = scala.io.Source.fromURL("https://github.com/yarwest/Git-production-trigger/commits/master", "UTF-8")
val commitString: String = ".*class=\"message\".*"

retrieveCommitHash(doc.getLines.filter(line => line.matches(commitString)).next)

doc.close

def retrieveCommitHash(str : String) : String = {
    return str.replaceFirst("</a>", "").replaceFirst("^.*href=\".*/", "").replaceFirst("\".*$", "")
}
