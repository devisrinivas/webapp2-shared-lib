def call() {
  sshagent(['tomcat-dev']) {
                  // copy war file to tomcat webapps
                 sh "scp target/webapp1.war ec2-user@172.31.6.32:/opt/tomcat9/webapps/"
                 sh "ssh ec2-user@172.31.6.32 /opt/tomcat9/shutdown.sh"
                 sh "ssh ec2-user@172.31.6.32 /opt/tomcat9/startup.sh"

                 }
}
