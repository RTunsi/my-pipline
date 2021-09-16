CODE_CHANGES = getGitChanges()
pipeline {
  
  agent any
  tools {
    maven 'Maven'
  }
  parameters{
    choice(name:'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description:'')
    booleanParam(name:'executeTests', defaultValue: true, description:'')
  }
  environment {
    NEW_VERSION = '1.2.0'
    SERVER_CREDENTIALS = credentails('')
  }
  stages {

    stage("build") {

      steps {
        echo 'building the application..'
        echo "building version ${NEW_VERSION}"
        sh "mvn install"
      }
    }

    stage("test") {
      when {
        expression {
          BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
          params.executeTests
        }
      }
      steps {
        echo 'testing the application..'
      }
    }

    stage("deploy") {

      steps {
        echo 'deploying the application..'
        echo "deploying version ${params.VERSION}"
      }
    }
  }             
}
