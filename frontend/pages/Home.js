import React ,{ useState}from 'react';
import { StyleSheet, Text, TextInput, View,Button, Alert } from 'react-native';

export default function Home({navigation}){



    const add =()=> { 
        navigation.navigate("Add");
    }
    const search =()=> { 
        navigation.navigate("Search");
    }
    const del =()=> { 
        navigation.navigate("Delete");
    }

    return (
        <View style={styles.container}>
            <Text>{test}</Text>
           
           <Button  title="add new Employe"  onPress={add}/>
           <Button  title="update Employe"   onPress={search} />
           <Button  title="delete Employe"   onPress={del}/>
       
   
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
      
    },

    Button:{
        
    }
});