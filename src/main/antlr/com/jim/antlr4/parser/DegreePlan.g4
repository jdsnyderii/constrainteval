grammar DegreePlan;

@header {
package com.jim.antlr4.parser;
}

@members {
    int count = 0;
}

tokens {
    DEGREE_PLAN_T, AND_REQ_T, OR_REQ_T, COURSELIST_REQ_T
}

parse:
    degree_plan EOF
;

degree_plan:
    DEGREE_PLAN_T (degree_plan_req)+
;

degree_plan_req:
    course_list_req
|   n_ary_boolean_req
;

course_list_req:
    COURSELIST_REQ_T
;
n_ary_boolean_req:
    and_req
|   or_req
;

and_req:
    AND_REQ_T (degree_plan_req)+
;

or_req:
    OR_REQ_T (degree_plan_req)+
;
