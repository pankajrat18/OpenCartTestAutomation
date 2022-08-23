pipeline{
    
    agent any 
    
    stages {
        
        stage("Build") {
            steps {
                echo("build the project")
            }
            
            
        }
        
        stage("Deploy on dev") {
            steps {
                echo("Deploy on dev")
            }
        
        
    }
    
    stage("Deploy on QA env") {
            steps {
                echo("Deploy on QA env")
            }
        
        
    }
    
        stage("Running test cases on QA env") {
            steps {
                echo("Running regression test cases on QA env")
            }
        
        
    }
    
           stage("Running test cases on UAT env") {
            steps {
                echo("Running sanity test cases on UAT env")
            }
        
        
    }
    
               stage("Deploy to Prod") {
            steps {
                echo("Deploy to Prod")
            }
        
        
    }
    }
}