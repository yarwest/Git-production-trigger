# Git production trigger
A Scala app that will pull the local repository when the remote repo has received a new commit.

The current implementation works with Git repositories that are hosted on GitHub and that are accessible to the public.

## Setup
Since this app is based on Scala you will need to install both Java and Scala which can easily be done trough ```apt-get```

Install Java
```
    sudo apt-get install default-jdk
```

Install Scala
```
    sudo apt-get install scala
```

After installing all the required packages, I suggest setting up a cronjob that will execute the script periodically. My preference goes out to a cycle of half an hour or an hour.
