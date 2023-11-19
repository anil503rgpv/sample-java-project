node {
  def jdk = tool 'jdk17'
  def mvn = tool 'maven3';

  stage('SCM') {
    checkout scm
  }
  stage('Building jar '){
    steps {
      sh "echo 'Building jenkins job'"
    }
  }
  stage('SonarQube Analysis') {

    withSonarQubeEnv(credentialsId: 'sonar') {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=anil503rgpv_sample-java-project_AYvl0QZq3bvwGHI8qXIb"
    }
  }
}