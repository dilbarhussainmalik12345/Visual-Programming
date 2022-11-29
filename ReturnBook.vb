Public Class ReturnBook

    Private Sub Button9_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button9.Click
        Me.Close()
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        If ComboBox1.Text = "" Then
            MsgBox("Please mention the Book ID", 0, "")
        Else
            Try
                If objcon.State = ConnectionState.Closed Then objcon.Open()
                com = New OleDb.OleDbCommand("UPDATE Books SET status='Available' WHERE BookID='" & ComboBox1.Text & "'", objcon)
                com.ExecuteNonQuery()
                objcon.Close()
                Call readData()
                If objcon.State = ConnectionState.Closed Then objcon.Open()
                com = New OleDb.OleDbCommand("INSERT INTO Returns VALUES('" & ComboBox1.Text & "','" & ComboBox2.Text & "','" & TextBox2.Text & "','" & ComboBox5.Text & "','" & TextBox1.Text & "','" & TextBox3.Text & "','" & TextBox7.Text & "','" & DateTimePicker2.Text & "','" & TextBox6.Text & "')", objcon)
                com.ExecuteNonQuery()
                MsgBox("Book has been returned!", 0, "")
                objcon.Close()
            Catch ex As Exception
                MsgBox(ex.Message, 0, "")
            End Try
        End If
    End Sub

    Private Sub Button8_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button8.Click
        If ComboBox1.Text = "" Then
            MsgBox("Please mention a Book ID", 0, "")
        Else

            Try
                If objcon.State = ConnectionState.Closed Then objcon.Open()
                com = New OleDb.OleDbCommand("DELETE FROM Returns WHERE BookID='" & ComboBox1.Text & "'", objcon)
                com.ExecuteNonQuery()
                MsgBox("Deleted Success!", 0, "")
                Call ClearThem()
                objcon.Close()
            Catch ex As Exception

            End Try
        End If
    End Sub
    Sub ClearThem()
        ComboBox1.TabIndex = ""
        ComboBox2.Text = ""
        TextBox2.Text = ""
        TextBox3.Text = ""
        TextBox6.Text = ""
        ComboBox5.Text = ""
        TextBox1.Text = ""
        TextBox7.Text = ""
        DateTimePicker2.Refresh()
    End Sub
  
    Private Sub ReturnBook_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Call BookID_Combo()
        Call readData()

    End Sub
    Sub BookID_Combo()
        Try
            If objcon.State = ConnectionState.Closed Then objcon.Open()
            com = New OleDb.OleDbCommand("Select BookID from Books WHERE status='Rented'", objcon)
            dr = com.ExecuteReader
            While dr.Read
                ComboBox1.Items.Add(dr.Item(0))
            End While
            dr.Close()
            objcon.Close()
        Catch ex As Exception

        End Try
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
        Try

            If (objcon.State = ConnectionState.Closed) Then objcon.Open()
            com = New OleDb.OleDbCommand("SELECT * FROM Books WHERE status='Rented'", objcon)
            dr = com.ExecuteReader
            While dr.Read()
                Call adddatatolistview(ListView1, dr(0), dr(1), dr(2), dr(3), dr(4), dr(5), dr(6), dr(7), dr(8))
            End While
            dr.Close()
            objcon.Close()
        Catch
            'MsgBox("Please Refresh", MsgBoxStyle.Information, "")
        End Try
    End Sub
    Public Sub adddatatolistview(ByVal lvw As ListView, ByVal BookID As String, ByVal GroupID As String, ByVal BookName As String, ByVal Publisher As String, ByVal Author As String, ByVal PubYear As String, ByVal edi As String, ByVal pric As String, ByVal st As String)
        Dim lv As New ListViewItem
        lvw.Items.Add(lv)
        lv.Text = BookID
        lv.SubItems.Add(GroupID)
        lv.SubItems.Add(BookName)
        lv.SubItems.Add(Publisher)
        lv.SubItems.Add(Author)
        lv.SubItems.Add(PubYear)
        lv.SubItems.Add(edi)
        lv.SubItems.Add(pric)
        lv.SubItems.Add(st)
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Me.Refresh()
    End Sub

    Private Sub ListView1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ListView1.SelectedIndexChanged
        Dim i As Integer
        For i = 0 To ListView1.Items.Count - 1
            If ListView1.Items(i).Selected = True Then
                ComboBox1.Text = ListView1.Items(i).SubItems(0).Text
                Exit For
            End If
        Next
        ListView1.Focus()
        ListView1.FullRowSelect = True
    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        Dim i As Integer
        ListView1.SelectedItems.Clear()
        TextBox1.Focus()
        Try
            If Me.ComboBox1.Text = "" Then
                TextBox2.Text = ""
            Else
                For i = 0 To ListView1.Items.Count - 1
                    If ComboBox1.Text = ListView1.Items(i).SubItems(0).Text Then
                        ComboBox2.Text = ListView1.Items(i).SubItems(1).Text
                        TextBox2.Text = ListView1.Items(i).SubItems(2).Text
                        ListView1.Items(i).Selected = True
                        Exit For
                    End If
                Next
            End If
        Catch

        End Try
        Call IssueDetail()
    End Sub
    Sub IssueDetail() '
        Try
            If objcon.State = ConnectionState.Closed Then objcon.Open()
            com = New OleDb.OleDbCommand("Select IssueDate, IssueName, IssueTo, DueDate from Issue WHERE BookID='" & ComboBox1.Text & "'", objcon)
            dr = com.ExecuteReader
            While dr.Read
                ComboBox5.Text = dr.Item(2)
                TextBox1.Text = dr.Item(1)
                TextBox3.Text = dr.Item(0)
                TextBox7.Text = dr.Item(3)
            End While
            dr.Close()
            objcon.Close()
        Catch ex As Exception

        End Try
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
                    TextBox1.Text = ListView1.Items(i + 1).SubItems(0).Text
                    Exit For
                End If
            Next
            ListView1.Focus()
            ListView1.FullRowSelect = True
        Catch ex As Exception

        End Try
    End Sub
End Class