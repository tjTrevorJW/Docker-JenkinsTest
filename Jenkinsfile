pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage ('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage ('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
