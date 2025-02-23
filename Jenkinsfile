pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }
    stages {
        stage('GIT') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AhlemTrabelsi22/DevOps.git'

            }
        }
        stage('Maven ') {
            steps {
                sh "java -version"
                sh "mvn -version"
            }
        }
    }
}
