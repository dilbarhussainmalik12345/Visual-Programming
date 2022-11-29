Module Class1
    Public objcon As New OleDb.OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" & Application.StartupPath & "\DataBase\LibraryData.mdb")
    Public com As OleDb.OleDbCommand
    Public dr As OleDb.OleDbDataReader
End Module
