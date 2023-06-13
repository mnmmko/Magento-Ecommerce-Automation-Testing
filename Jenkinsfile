pipeline { 
    agent any
      stages {
       stage('Git Main Branch') {
         steps {
           git branch:'main', url:'https://github.com/mnmmko/Magento-Ecommerce-Automation-Testing'
                      }
			 }
    
    stage('Build') {
            
            steps {
           
                  
                bat 'mvn clean test'
                      
            }
        }
      stage('Build Docker Image') {
                
                steps {
               
                      
                    bat 'docker compose up -d'
                          
                }
            }
         stage('Push Docker Image') {
            
            steps {
           
                  
                bat 'docker push mnmmko/magento-ecommerce-automation-testing'
                      
            }
        }
         stage('Deployment app') {
            
              steps {
           
                  
                bat 'kubectl apply -f deployment-file.yml'
                      
                  }
        }
          }

}