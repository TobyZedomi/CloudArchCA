#!/bin/bash

sftp developer@your-ip-here  <<EOF
lcd MovieSystem/MovieSystem/target
cd holdJar
put MovieSystem-0.0.1-SNAPSHOT.jar
exit
EOF

