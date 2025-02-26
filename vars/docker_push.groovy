def call(String credsId, String imageName){
    withCredentials([usernamePassword(
        credentialsId: "${credsId}",
        usernameVariable: "dockerHubUser",
        passwordVariable: "dockerHubPass"
    )]){
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker image tag ${imageName} ${env.dockerHubUser}/${imageName}"
        sh "docker push ${env.dockerHubUser}/${imageName}:latest"
    }
}
                
            
