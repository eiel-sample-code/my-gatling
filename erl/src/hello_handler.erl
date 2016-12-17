-module(hello_handler).

-export([init/2]).

init(Req0, State) ->
	Req = cowboy_req:reply(200,
	    #{<<"content-type">> => <<"application/json">>},
	    <<"{\"status\": \"success\"}">>,
	    Req0),
	{ok, Req, State}.
