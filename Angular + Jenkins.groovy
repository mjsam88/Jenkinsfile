pipeline { 
  agent any
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Npm Audit') {
      steps {
        sh 'npm ci'
        sh 'npm audit'
      }
    }
    stage('Running ESLint') {
      steps {
        sh 'npm run lint'
      }
    }
    stage('Running StyleLint') {
      steps {
        sh 'npm run stylelint'
      }
    }
    stage('Running Unit Tests as part of the CI') {
      steps {
        sh 'npm run test'
      }
    }
    stage('Build') {
      steps {
        sh 'npm run build'
      }
    }
    stage('Deploy') {
      steps {
        # Add our Deployment script here
        # For example, deploying to a web server, a container, or a cloud service
      }
    }
  }
}
