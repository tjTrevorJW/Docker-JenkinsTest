pipeline {
	agent any
	
	stages {
		stage('Compile Stage') {
			steps {
				withMaven(maven : 'Maven') {
					sh 'mvn clean compile -o'
				}
			}
		
		}
		stage('Testing Stage') {
			steps {
				withMaven(maven : 'Maven') {
					sh 'mvn test -o'
				}
			}
		
		}	
		stage('Deployment Stage') {
			steps {
				withMaven(maven : 'Maven') {
					sh 'mvn deploy -o'
				}
			}
		}	
	}
	
}
