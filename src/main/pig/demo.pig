REGISTER lib/*.jar;

%declare LOGFILE   '${ACCESS_LOGPATH}/access*gz'
%declare LOGFORMAT '${ACCESS_LOGFORMAT}'

Clicks =
  LOAD '${LOGFILE}'
  USING nl.basjes.pig.input.apachehttpdlog.Loader( '$LOGFORMAT',
            'HTTP.URI:request.firstline.uri',
            'HTTP.PATH.CLASS:request.firstline.uri.path.class',
            '-load:nl.example.pig.demo.dissector.UrlClassDissector:',
            'STRING:request.firstline.uri.query.foo'
        )
        AS (
            URI:chararray,
            URIClass:chararray,
            Foo:chararray
        );

Stuff = FOREACH  Clicks
        GENERATE URI,
                 URIClass,
                 FLATTEN(nl.example.pig.demo.myudf.Tokenize(Foo)) AS tokens:chararray;

DUMP Stuff;

