def buildApp() {
  echo "Building the application"
}

def testApp() {
  echo "testing the application"
}

def Deployapp() {
  echo "Deploying the application"
  echo "deploying version ${params.VERSION}"
}


return this
