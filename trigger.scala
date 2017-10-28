val doc = scala.io.Source.fromURL("https://github.com/yarwest/Git-production-trigger/commits/master", "UTF-8")
val commitString: String = ".*class=\"message\".*"
println(doc.getLines.filter(line => line.matches(commitString)).next)

doc.close
