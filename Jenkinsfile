CODE_CHANGES = getGitChanges()

def gv

pipeline {
  agent any 
  
  parameters {                                                                                  // Type of parameters
    string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')         //  - string(name ,defaultValue, description)
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')              //  - choice(name,  choices, description)
    booleanParam(name: 'executeTests', defaultValue: true, description: '')                     //  - booleanParam(name, deafultValue, description)
  }
  
  tools {                           // access build tools for your project like maven, gradle, js , yarn
    maven                           // only 3 build tools available: gradle, maven and jdk
    gradle
    jdk
  }
  
  environment {
    NEW_VERSION = '1.3.0'
    SERVER_CREDENTIALS = credentials('')     // "credentials ("crdentialid") binds the crdentials to your env variable
                                             // for this you need " credentials Binding" plugin
  }
  
  stages {
    
    
    stage ("init") {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }
    
    stage("build1"){
      steps {
        script {
          gv.buildApp()
        }
      }
    }
    
    stage("test1"){
      steps {
        script {
          gv.buildApp()
        }
      }
    }
    
    stage("deploy1"){
      steps {
        script {
          gv.buildApp()
        }
      }
    }
    
    
  
    stage("build") {
      
      when {
        expression {
          BRANCH_NAME == "dev" && CODE_CHANGES == true
        }
      }
      
      steps {
        echo "Building the application"
        echo " Building Version ${NEW_VERSION}"
      }
    }
    
    stage("test") {
      
      when {
        expression {
          param.executesTests == true
        }
      }
      
      when {
        expression {
          BRANCH_NAME == "dev" || BRANCH_NAME == "prod"
        }
      }
      
      steps {
        echo "Testing the application"
      }
    }
    
    stage("deploy") {
      steps {
        echo "Deploying the application"
        echo " deploying verion ${params.VERSION} "
        echo " Deploying with ${SERVER_CREDENTIALS} "
        sh "${SERVER_CREDENTIALS}"
        // Also 
        withCredentials([
          usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passWordVariable: PWD    // server-credentials is ID
        ]) {
            sh " Some Script ${USER} ${PWD}
          }
          
          
      }
    }
 
  }
  
  post {
    always {
      //
    }
    success {
      //
    }
    failure {
      //
    }
    
  
  }
  
}  
