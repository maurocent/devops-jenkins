#!/bin/bash
echo "Bienvenido/a al planeta $planeta"
if [ "$agente" = "true" ]
then 
	echo "Preparece para la mision agente X, que la fuerza te acompañe."
else
	echo "Difruta el planeta humano/a $nombre, trata de no morir."
fi
echo " ... "
sleep 10
echo "¡Suerte! la necesitaras."