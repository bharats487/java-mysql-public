@Library ('shared-library') _

pipeline {
    agent any
    parameters {
        choice(name: 'action', choices: 'create\ndelete', description: 'choose create/Destry')
        string(name: 'ImageName', description:'Name of the docker build', defaultValue: 'java-app')
        string(name: 'ImageTag', description:'tag of the docker build', defaultValue: 'v1')
        string(name: 'DockerHubUser', description:'name of the application', defaultValue: 'bharats487')
    }

    stages{
        stage('Git Checkout'){
            steps{
                gitCheckout(
                    branch: "main",
                    url: "https://github.com/bharats487/java-mysql-public.git"
                )
            }
        }
        stage('Unit Test maven'){
            steps{
                script{
                    mvnTest()
                }
            }
        }

        stage('static code analysis: sonarqube'){
            steps{
                script{
                    def sonarQubcredentialsId = 'jenkin'
                    staticCodeAnalysis(sonarQubcredentialsId)
                }
            }
        }

        stage('quality Gate status check: sonarqube'){
            steps{
                script{
                    def sonarQubcredentialsId = 'jenkin'
                    QualityGatestatus(sonarQubcredentialsId)
                }
            }
        }
        stage('Maven Build: Maven'){
            steps{
                script{
                    mvnBuild()
                }
            }
        }

        stage('Docker Image Build'){
            when {expression {params.action == 'create'}}
            steps{
                script{
                    dockerBuild("${params.ImageName}","${params.ImageTag}","${params.DockerHubUser}")
                }
            }
        }

        stage('Docker Image Scan: trivy'){
            when {expression {params.action == 'create'}}
            steps{
                script{
                   dockerImageScan("${params.ImageName}","${params.ImageTag}","${params.DockerHubUser}")
                }
            }
        }

    }
}