import 'package:etudiants/services/EtudiantService.dart';
import 'package:flutter/material.dart';

import 'models/EtudiantsModels.dart';

final ThemeData themeData = ThemeData(
    primarySwatch: Colors.blue,
  );
void main() {
  
  runApp(MaterialApp(
      debugShowCheckedModeBanner: false,
       theme: themeData,
      home: Scaffold(
        appBar: AppBar(
          title: Text('Liste des Etudiants'),
        ),
        body:ListeEtudiant()
  )));
}

class ListeEtudiant extends StatefulWidget {
  @override
  _ListeEtudiantState createState() => _ListeEtudiantState();
}

class _ListeEtudiantState extends State<ListeEtudiant> {
  final EtudiantService etudiantService = EtudiantService();
  List<Etudiant> etudiants = [];

  @override
  void initState() {
    super.initState();
    fetchAllEtudiants();
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          ListView.builder(
            shrinkWrap: true,
            itemCount: etudiants.length,
            itemBuilder: (context, index) {
              return ListTile(
                title: Text(etudiants[index].nomComplet),
                subtitle: Text(etudiants[index].matricule),
                leading: Text(etudiants[index].classe),
                trailing: Text(etudiants[index].email),
              );
            },
          ),
          ElevatedButton(
            onPressed: () {
              fetchAllEtudiants();
            },
            child: Text('voir la liste de tous les étudiants'),
          ),
          ElevatedButton(
            onPressed: () {
              fetchEtudiantsByClasse('L1 MAE');
            },
            child: Text('lister les Etudiants de la MAE 1'),
          ),
        ],
      ),
    );
  }

  void fetchAllEtudiants() async {
    try {
      List<Etudiant> allEtudiants = await EtudiantService.getAllEtudiants();
      setState(() {
        etudiants = allEtudiants;
      });
    } catch (e) {
      print('Information indisponible: $e');
    }
  }

  void fetchEtudiantsByClasse(String classe) async {
    try {
      List<Etudiant> etudiantsByClasse = await EtudiantService.getEtudiantsByClasse(classe);
      setState(() {
        etudiants = etudiantsByClasse;
      });
    } catch (e) {
      print('Information indisponible: $e');
    }
  }
}

