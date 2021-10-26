@echo off
%//0黑 1蓝 2绿 3浅绿..%
color 06
%your consul server install path %
cmd /k "cd /d D:\consul_1.10.3_windows_amd64&&consul agent -dev"
