job('Ejemplo2-job-DSL'){
	description('Job DSL de ejemplo con su descripcion')
  	scm {
    	 git('https://github.com/maurocent/devops-jenkins.git', 'main') { node -> 
            node / gitConfigName('maurocent')
            node / gitConfigEmail('acentenoarias@gmail.com')
        }
    }
  	parameters {
        stringParam('nombre', defaultValue = 'Amaury', description = 'Parametro de cadena para el Job booleano')
      	choiceParam('planeta', ['Tierra', 'Mercurio', 'Venus', 'Saturno'])
        booleanParam('agente', false)
    }
  	triggers {
    cron('H/7 * * * *')
  	}
  	steps {
    	shell("bash jobscript.sh")
    }
  publishers {
  		mailer('mcent0811@gmail.com', true, true)
    	slackNotifier {
          notifyAborted(true)
          notifyEveryFailure(true)
          notifyNotBuilt(false)
          notifyUnstable(false)
          notifyBackToNormal(true)
          notifySuccess(false)
          notifyRepeatedFailure(false)
          startNotification(true)
          includeTestSummary(false)
          includeCustomMessage(false)
          customMessage(null)
          sendAs(null)
          commitInfoChoice('NONE')
          teamDomain(null)
          authToken(null)
        }
  }
}
