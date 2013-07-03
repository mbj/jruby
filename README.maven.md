maven profiles
==========

    mvn -P all
    mvn -P dist
    mvn -P complete
    mvn -P main
    mvn -P rake-plugin
    mvn -P docs
    mvn -P test

clean build
---------

    mvn clean package -Pconstants

or executing both in sequence:

    mvn clean
    mvn
