pipeline {
    agent any

    stages {

        stage('Checkout SCM') {
            steps {
                echo 'Récupération du projet depuis GitHub...'
            }
        }

        stage('Test Jenkins') {
            steps {
                echo 'Jenkins fonctionne correctement !'
            }
        }

        stage('Environment') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'node --version'
                bat 'npm --version'
            }
        }
    }
}
