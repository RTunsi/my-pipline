def gv
          
pipeline {
  
  agent any
          tools {
                    maven 'Maven'
          }
          parameters {
                    choice(name:'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description:'')
                    booleanParam(name:'executeTests', defaultValue: true, description:'')
          }
          environment {
                    NEW_VERSION = '1.2.0'
                    //SERVER_CREDENTIALS = credentails('')
          }
          stages {
    
                    stage('init') {
                              steps {
                                        script {
                                                  gv = load "script.groovy"          
                                        }
                              }
                    }

                    stage("build") {
                              steps {
                                        script{
                                                  gv.buildApp()
                                        }

                                        //sh "mvn install"
                              }
                    }

                    stage("test") {
                              when {
                                        expression {
                                                  //BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
                                                  params.executeTests
                                        }
                              }
                              steps {
                                        script {
                                                  gv.testApp()    
                                        }
                              }
                    }

                    stage("deploy") {
                              steps {
                                        script {
                                                  gv.deployApp() 
                                        }
                              }
                    }
          }             
}
