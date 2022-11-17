def call(Creds,tomcatIp,userName,warName) {
  sshagent([Creds]) {
    // copy war file to tomcat webapps
    sh "scp -o StrictHostkeyChecking=no target/${warName}.war ${userName}@${tomcatIp}:/opt/tomcat9/webapps/"
    sh "ssh ${userName}@${tomcatIp} /opt/tomcat9/shutdown.sh"
    sh "ssh ${userName}@${tomcatIp}/opt/tomcat9/startup.sh"
    }
}
