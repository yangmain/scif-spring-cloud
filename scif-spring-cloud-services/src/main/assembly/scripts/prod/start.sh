#!/bin/bash
# running service shell

echo -e " running service shell by Jimmy.Huang"
#==============================================
# env setting
#==============================================
# 解决部分机器找不到JAVA_HOME的问题
source ~/.bash_profile
SERVER_NAME=${project.artifactId}
ENV=${env}

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`

# classpath setting
[ ! -e "$CP" ] && CP=$JAVA_HOME/lib
CP=.:${CP}/*:${DEPLOY_DIR}/*

PIDS=`ps -ef | grep java | grep "$DEPLOY_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi

#==============================================
# vm setting
#==============================================
JAVA_OPT="${JAVA_OPT} -server -Xmx1024m -Xms1024m"
JAVA_OPT="${JAVA_OPT} -XX:MaxDirectMemorySize=512m -Dio.netty.recycler.maxCapacity.default=0 -Dio.netty.leakDetectionLevel=advanced"
JAVA_OPT="${JAVA_OPT} -XX:+UseG1GC -XX:G1HeapRegionSize=16m -XX:G1ReservePercent=25 -XX:InitiatingHeapOccupancyPercent=30 -XX:SoftRefLRUPolicyMSPerMB=0 -XX:SurvivorRatio=8"
JAVA_OPT="${JAVA_OPT} -verbose:gc -Xloggc:gclog -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+PrintAdaptiveSizePolicy"
JAVA_OPT="${JAVA_OPT} -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=30m"
JAVA_OPT="${JAVA_OPT} -XX:HeapDumpPath=logs/${SERVER_NAME}.hprof -XX:+HeapDumpOnOutOfMemoryError"
JAVA_OPT="${JAVA_OPT} -XX:-OmitStackTraceInFastThrow"
JAVA_OPT="${JAVA_OPT} -Dspring.profiles.active=${ENV}"
JAVA_OPT="${JAVA_OPT} -cp ${CP}"

echo -e "Starting the $SERVER_NAME ...\c"
nohup java $JAVA_OPT -jar ${SERVER_NAME}.jar  > /dev/null 2>&1 &

PIDS=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}'`
if [ -n "$PIDS" ]; then
 echo "OK!"
 echo "PID: $PIDS [OK]"
fi