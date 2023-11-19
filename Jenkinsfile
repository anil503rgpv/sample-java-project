node {
  stage('SCM') {
    checkout scm
  }
  stage('Building jar '){
    def mvn = tool 'maven3'
    steps {
      sh "echo 'Building jenkins job'"
    }
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'maven3'
    withSonarQubeEnv(credentialsId: 'sonar') {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=anil503rgpv_sample-java-project_AYvl0QZq3bvwGHI8qXIb"
    }
  }
}