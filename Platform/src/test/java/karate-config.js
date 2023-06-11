function fn() {

  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }

  var config = {
    username: 'test_qa_user',
    password: 'Qwerty123#',
    accessToken:''
  }

 var result = karate.callSingle('classpath:Washmetrix/Features/login.feature', config);
 config.accessToken = result.response.AuthenticationResult.AccessToken;

  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
  } else if (env == 'e2e') {
    // customize
  }
  return config;
}