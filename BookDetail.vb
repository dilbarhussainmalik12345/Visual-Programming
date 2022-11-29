Public Class BookDetail
    Dim sel As Integer
    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        Label1.Text = ComboBox1.Text
        Label1.Visible = True
        If Label1.Text = "STATUS" Then
            ComboBox2.Enabled = True
            ComboBox2.Visible = True
            TextBox1.Visible = False
            
        Else
            ComboBox2.Enabled = False
            ComboBox2.Visible = False
            TextBox1.Visible = True
          
        End If
        Call forselect()
    End Sub
    Sub forselect()
        If ComboBox1.Text = "BOOK ID" Then
            sel = 1
        ElseIf ComboBox1.Text = "BOOK NAME" Then
            sel = 2
        ElseIf ComboBox1.Text = "AUTHOR" Then
            sel = 3
        ElseIf ComboBox1.Text = "STATUS" Then
            sel = 8
        End If
    End Sub

    Private Sub BookDetail_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        ComboBox2.Visible = False
        TextBox1.Visible = False
        Label1.Visible = False
        Call readData()
    End Sub
    Sub readData()
        ListView1.Clear()
        ListView1.Columns.Add("BOOK ID", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("GROUP ID", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("BOOK NAME", 310, HorizontalAlignment.Center)
        ListView1.Columns.Add("PUBLISHER", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("AUTHOR", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("PUBLISHING YEAR", 130, HorizontalAlignment.Center)
        ListView1.Columns.Add("EDITION", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("PRICE", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("STATUS", 90, HorizontalAlignment.Center)
        ListView1.View = View.Details
        sel = 5
        'Call whenclick()
    End Sub
    Sub whenclick()
        Try

            While dr.Read()
                Call adddatatolistview(ListView1, dr(0), dr(1), dr(2), dr(3), dr(4), dr(5), dr(6), dr(7), dr(8))
            End While
            dr.Close()
            objcon.Close()
        Catch
            'MsgBox("Please Refresh", MsgBoxStyle.Information, "")
        End Try
    End Sub
    Public Sub adddatatolistview(ByVal lvw As ListView, ByVal BookID As String, ByVal GroupID As String, ByVal BookName As String, ByVal publisher As String, ByVal author As String, ByVal pubyear As String, ByVal edi As String, ByVal pric As String, ByVal status As String)
        Dim lv As New ListViewItem
        lvw.Items.Add(lv)
        lv.Text = BookID
        lv.SubItems.Add(GroupID)
        lv.SubItems.Add(BookName)
        lv.SubItems.Add(publisher)
        lv.SubItems.Add(author)
        lv.SubItems.Add(pubyear)
        lv.SubItems.Add(edi)
        lv.SubItems.Add(pric)
        lv.SubItems.Add(status)
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If objcon.State = ConnectionState.Closed Then objcon.Open()
        Select Case (sel)
            Case 1
                com = New OleDb.OleDbCommand("select * from Books where BookID='" & TextBox1.Text & "'", objcon)
                dr = com.ExecuteReader
            Case 2
                com = New OleDb.OleDbCommand("select * from Books where BookName='" & TextBox1.Text & "'", objcon)
                dr = com.ExecuteReader
            Case 3
                com = New OleDb.OleDbCommand("select * from Books where Author='" & TextBox1.Text & "'", objcon)
                dr = com.ExecuteReader
            Case 5
                com = New OleDb.OleDbCommand("select * from Books", objcon)
                dr = com.ExecuteReader
            Case 8
                com = New OleDb.OleDbCommand("select * from Books where Status='" & ComboBox2.Text & "'", objcon)
                dr = com.ExecuteReader
        End Select
        Call readData()
        Call whenclick()
        objcon.Close()
    End Sub

    Private Sub ListView1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ListView1.SelectedIndexChanged

    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Try
            Dim i As Integer
            For i = 0 To ListView1.Items.Count - 1
                If ListView1.Items(i).Selected = True Then
                    TextBox1.Text = ListView1.Items(i + 1).SubItems(0).Text
                    Exit For
                End If
            Next
            ListView1.Focus()
            ListView1.FullRowSelect = True
        Catch ex As Exception

        End Try
    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        Try
            Dim i As Integer
            For i = 0 To ListView1.Items.Count - 1
                If ListView1.Items(i).Selected = True Then
                    TextBox1.Text = ListView1.Items(i - 1).SubItems(0).Text
                    Exit For
                End If
            Next
            ListView1.Focus()
            ListView1.FullRowSelect = True
        Catch ex As Exception

        End Try
    End Sub
End Class