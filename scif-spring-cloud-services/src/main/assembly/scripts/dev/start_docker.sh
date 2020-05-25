#!/bin/bash
# running service shell

echo -e " running service shell by Jimmy.Huang"
#==============================================
# env setting
#==============================================
SERVER_NAME=${project.artifactId}
ENV=${env}

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
JAVA_OPT="${JAVA_OPT} -Duser.timezone=GMT+08"
JAVA_OPT="${JAVA_OPT} -Dspring.profiles.active=${ENV}"



echo -e "Starting the $SERVER_NAME ...\c"
cd ..
java $JAVA_OPT -jar ${SERVER_NAME}.jar